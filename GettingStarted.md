# Hello, JAnnocessor world! #

JAnnocessor is a new Java framework that can be used for:
  * processing of annotated Java source code,
  * Java cource code generation.

It will usually be used to do both of them - to process the annotated Java code and use it as a model for the generation of additional source code.

JAnnocessor is built on top of Java APT, but hides it away from the Java developer, encapsulating the Java source code model in a rich and high-level domain model, that is very easy to work with.

To start using JAnnocessor, you can add it to your project as a Maven dependency.

# Adding JAnnocessor as Maven dependency #

JAnnocessor is in the Maven central repository, so it can be added to the project by this simple Maven configuration:

```
<dependency>
    <groupId>com.googlecode.jannocessor</groupId>
    <artifactId>jannocessor</artifactId>
    <version>0.7.2</version>
</dependency>
```

# Configuring JAnnocessor as APT annotation processor #

JAnnocessor is built on top of Java APT, and its entry point is an APT annotation processor. It has built-in Maven plugin, which can be configured like in the following example Maven configuration:

```
<plugin>
	<groupId>com.googlecode.jannocessor</groupId>
	<artifactId>jannocessor-maven-plugin</artifactId>
	<version>0.7.2</version>
	<executions>
		<execution>
			<id>generate-code</id>
			<phase>compile</phase>
			<goals>
				<goal>process</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

This way JAnnocessor is configured to run as part of the _compile_ phase of the Maven build cycle.

# Running JAnnocessor #

Once JAnnocessor is configured for your project, you need some annotated class to be able to run it:

```
@MyAnnotation
public class MyAnnotatedClass {
    ...
}
```

You also need to configure it what to search for and what to do when a match is found. In this case, it can process all classes that are annotated with `@MyAnnotation`:

```
public class Processors {

	@Annotated(MyAnnotation.class)
	@Types(JavaClass.class)
	public MyProcessor willProcessMyAnnotatedClasses() {
		return new MyProcessor();
	}

}
```

The class Processors is a way to use Java source code for configuration, instead of some textual property files. It must be inside the org.jannocessor.config package. This way, JAnnocessor knows by convention to look for the class **org.jannocessor.config.Processors** for the configuration.

Now you have configured all classes annotated with `@MyAnnotation` to be processed with an instance of the `MyProcessor` code processor, which must implement the `CodeProcessor` interface that's part of JAnnocessor:

```
public interface CodeProcessor<T extends JavaElement> {

	void process(PowerList<T> code, ProcessingContext context);

}
```


# Implementing the code processor #

The purpose of the code processor is to manipulate the source code model that represents the annotated code that needs to be processed.

The following code processes a list of all classes that were configured to be processed with it (all classes annotated with `@MyAnnotation`). The source code model is rich and convenient for transformations:

```
public class MyProcessor implements CodeProcessor<JavaClass> {

	@Override
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		context.getLogger().info("Processing {} classes", classes.size());

		for (JavaClass clazz : classes) {
			clazz.getName().appendPart("Gen");
			clazz.getMetadata().clear();

			for (JavaField field : clazz.getFields()) {
				field.getModifiers().assign(Fields.PRIVATE);

				String getterName = field.getName().copy().insertPart(0, "get").toString();
				JavaMethod getter = New.method(Methods.PUBLIC, field.getType(), getterName);
				getter.getBody().setHardcoded(String.format("return this.%s;", field.getName()));

				clazz.getMethods().add(getter);
			}

			context.generateCode(clazz, true);
		}
	}

}
```

This simple code processor has only a few lines of code, and it's already enough to generate the folowing source code:

```
package org.jannocessor.experiment.model;

public class MyAnnotatedClassGen {

    private String field1;

    private int field2;

    public String getField1() {
        return this.field1;
    }

    public int getField2() {
        return this.field2;
    }

}
```