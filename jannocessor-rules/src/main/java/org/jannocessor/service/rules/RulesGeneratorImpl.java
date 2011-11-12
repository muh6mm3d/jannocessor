/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.service.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jannocessor.JannocessorException;
import org.jannocessor.context.Rule;
import org.jannocessor.service.api.FileService;
import org.jannocessor.service.api.PatternService;
import org.jannocessor.service.api.RulesGenerator;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RulesGeneratorImpl implements RulesGenerator, Settings {

	private Logger logger = LoggerFactory.getLogger("RULES");

	private final TemplateRenderer renderer;

	private final FileService fileService;

	private final PatternService patternService;

	@Inject
	public RulesGeneratorImpl(TemplateRenderer renderer,
			FileService fileService, PatternService patternService)
			throws JannocessorException {
		this.renderer = renderer;
		this.fileService = fileService;
		this.patternService = patternService;

		// TODO: enable this when needed
		// renderer.configure(null, false);
	}

	@Override
	public String generateRules(String[] ruleNames) throws JannocessorException {
		Map<String, Object> attributes = new HashMap<String, Object>();

		List<Rule> rules = new ArrayList<Rule>();

		for (String ruleName : ruleNames) {
			rules.add(loadRule(ruleName));
		}

		attributes.put("rules", rules);

		String rulesText = renderer.renderFromFile(RULES_TEMPLATE_NAME,
				attributes);

		logger.debug("Generated rules:\n{}", rulesText);
		return rulesText;
	}

	private Rule loadRule(String name) {
		String filename = "patterns/" + name + ".match";

		String pattern = fileService.readClasspathFile(filename);
		logger.debug("Loading pattern:\n{}", pattern);

		List<String> args = patternService.extractPatternVariables(pattern);
		Rule rule = new Rule(name, pattern, args);

		return rule;
	}

}
