package io.github.rampantlions.codetools;


import org.jboss.forge.roaster.model.source.JavaClassSource;

public abstract class CommonProcessor implements ProcessorFacade
{
	protected boolean changeMade = false;
	protected static String COMMONMODEL = "io.github.rampantlions.codetools.CommonModel";

	public static String getCommonModel()
	{
		return COMMONMODEL;
	}

	public static void setCommonModel( String CommonModel )
	{
		COMMONMODEL = CommonModel;
	}

	protected ProcessorSettings config = null;

	public CommonProcessor()
	{
		super();
	}

	public CommonProcessor( ProcessorSettings config )
	{
		super();
		this.config = config;
	}

	public boolean isChangeMade()
	{
		return changeMade;
	}

	public void resetChangeMade()
	{
		changeMade = false;
	}

	@Override
	public void processMainClass( JavaClassSource javaClass )
	{}

	@Override
	public void processMethods( JavaClassSource javaClass )
	{}

	@Override
	public void processStaticFields( JavaClassSource javaClass )
	{}

	@Override
	public void processNonStaticFields( JavaClassSource javaClass )
	{}

	@Override
	public void processFields( JavaClassSource javaClass )
	{}
}
