/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.bootstrap.processor;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.CopyAction;

import org.apache.commons.beanutils.MethodUtils;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.data.JavaClassData;
import org.jannocessor.data.JavaPackageData;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.structure.JavaPackageBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingContext;

public class DomainProxyGenerator implements CodeProcessor<JavaInterface> {

	private DomainProxyGeneratorHelper helper = new DomainProxyGeneratorHelper();

	public void process(ProcessingContext context, Map<String, Object> params) {
		JavaInterface model = (JavaInterface) params.get("model");
		context.getLogger().debug("Processing annotated domain model: {}",
				model);

		context.getLogger().debug("Generating model proxies...");
		generateModelProxies(context, model, helper);

		context.getLogger().debug("Generating model base beans...");
		generateBaseModel(context, model, helper);

		// context.getLogger().debug("Generating model beans...");
		// generateModelBeans(context, model, helper);
	}

	private void generateModelProxies(ProcessingContext context,
			JavaInterface model, DomainProxyGeneratorHelper helper) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		String packageName = "org.jannocessor.proxy";
		String className = model.getName().appendPart("Proxy").getText();

		attributes.put("model", model);
		attributes.put("packageName", packageName);
		attributes.put("className", className);
		attributes.put("helper", helper);

		// context.generateFile(packageName, className + ".java", "model_proxy",
		// attributes);
	}

	private void generateBaseModel(ProcessingContext context,
			JavaInterface model, DomainProxyGeneratorHelper helper) {
		Map<String, Object> attributes2 = new HashMap<String, Object>();
		String packageName2 = "org.jannocessor.data";
		String className2 = model.getName().appendPart("Data").getText();

		attributes2.put("model", model);
		attributes2.put("packageName", packageName2);
		attributes2.put("className", className2);
		attributes2.put("helper", helper);

		// context.generateFile(packageName2, className2 + ".java",
		// "model_data",
		// attributes2);
	}

	@SuppressWarnings("unused")
	private void generateModelBeans(ProcessingContext context,
			JavaInterface model, DomainProxyGeneratorHelper helper) {
		Map<String, Object> attributes3 = new HashMap<String, Object>();
		String packageName3 = "org.jannocessor.model.bean";
		String className3 = model.getName().appendPart("Bean").getText();

		attributes3.put("model", model);
		attributes3.put("packageName", packageName3);
		attributes3.put("className", className3);
		attributes3.put("helper", helper);

		// context.generateFile(packageName3, className3 + ".java",
		// "model_bean",
		// attributes3);
	}

	@Override
	public void process(PowerList<JavaInterface> api, ProcessingContext context) {
		for (JavaInterface model : api) {
			JavaClass bean = createBean(model);
			JavaClass proxy = createProxy(model);

			context.generateCode(bean, false);
			context.generateCode(proxy, false);
		}
	}

	private JavaClass createBean(JavaInterface model) {
		JavaClass bean = New.classs(Classes.PUBLIC, model.getName().copy()
				.appendPart("Data").toString());

		// work-around to set the name
		((JavaClassData) bean).setPackageName(New.name("org.jannocessor.data"));

		PowerList<JavaMethod> methods = model.getMethods();

		// add fields
		for (JavaMethod method : methods) {
			String fieldName = helper.fieldName(method);

			JavaField field = New.field(Fields.PRIVATE, method.getReturnType(),
					fieldName);
			bean.getFields().add(field);

			JavaMethod getter = ModelUtils.copy(method);
			String getterCode = String.format("return this.%s;", fieldName);
			getter.getBody().setHardcoded(getterCode);
			bean.getMethods().add(getter);

			JavaMethod setter = ModelUtils.copy(method);
			setter.getName().replacePart(0, "set");
			String setterCode = String.format("this.%s = %s;", fieldName, fieldName);
			getter.getBody().setHardcoded(setterCode);
			bean.getMethods().add(setter);
		}

		return bean;
	}

	private JavaClass createProxy(JavaInterface model) {
		JavaClass proxy = New.classs(Classes.PUBLIC, model.getName().copy()
				.appendPart("Proxy").toString());

		// work-around to set the name
		((JavaClassData) proxy).setPackageName(New
				.name("org.jannocessor.proxy"));

		return proxy;
	}

}
