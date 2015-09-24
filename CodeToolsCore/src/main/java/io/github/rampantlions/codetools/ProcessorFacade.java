
package io.github.rampantlions.codetools;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public interface ProcessorFacade
{
	public void processMainClass( JavaClassSource javaClass );

	public void processMethods( JavaClassSource javaClass );

	public void processStaticFields( JavaClassSource javaClass );

	public void processNonStaticFields( JavaClassSource javaClass );

	public void processFields( JavaClassSource javaClass );

	public boolean isChangeMade();

	public void resetChangeMade();
}
