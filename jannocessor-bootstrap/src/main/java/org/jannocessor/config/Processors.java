package org.jannocessor.config;

import org.jannocessor.annotation.Annotated;
import org.jannocessor.annotation.DomainModel;
import org.jannocessor.annotation.Types;
import org.jannocessor.bootstrap.processor.DomainProxyGenerator;
import org.jannocessor.model.structure.JavaInterface;

public class Processors {

	@Annotated(DomainModel.class)
	@Types(JavaInterface.class)
	public DomainProxyGenerator beansAndProxyGenerator() {
		return new DomainProxyGenerator();
	}

}
