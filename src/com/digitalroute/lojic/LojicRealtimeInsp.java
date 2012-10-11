package com.digitalroute.lojic;

import java.util.Iterator;
import java.util.Set;

import com.digitalroute.devkit.exception.DRException;
import com.digitalroute.devkit.wf.DRAgentInspectable;
import com.digitalroute.devkit.drudr.DRTypeInfo;
import com.digitalroute.devkit.drudr.DRUDRDesc;
import com.digitalroute.devkit.drudr.DRUDRRawDataDesc;

public class LojicRealtimeInsp extends DRAgentInspectable
{
	    private static final String ICON_NAME = "com/digitalroute/lojic/lojic.svg";

	    public String getIconName() 
		{
	        return ICON_NAME;
	    }

	    public String getUIClassName() 
		{
	        return LojicRealtimeStng.class.getName();
	    }

	    public String getExecClassName() 
		{
	        return LojicRealtimeExec.class.getName();
	    }

	    public String getName() 
		{
	        return "LOJIC";
	    }

	    public DRUDRDesc[] getInputTypes() throws DRException 
		{
	        return new DRUDRDesc[]{DRUDRDesc.baseUDRType(), DRUDRRawDataDesc.instance()};
	    }

	    public DRUDRDesc[] getOutputTypes(String routeName) throws DRException 
		{
	        return getInputTypes();
	    }

	    @Override
	    public String getConfigClassName() 
		{
	        return LojicData.class.getName();
	    }
	   
	    public String validate() throws DRException 
		{
			return super.validate();
	    }
	}