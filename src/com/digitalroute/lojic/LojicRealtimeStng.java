package com.digitalroute.lojic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import java.awt.*;

import com.digitalroute.devkit.drudr.DJUDRTypeSelector;
import com.digitalroute.devkit.drudr.DRUDRClassDesc;
import com.digitalroute.devkit.drudr.DRUDRDesc;
import com.digitalroute.devkit.exception.DRException;
import com.digitalroute.devkit.misc.DRPassword;
import com.digitalroute.devkit.storable.DRStorable;
import com.digitalroute.devkit.ui.DJIntegerField;
import com.digitalroute.devkit.ui.DJLabel;
import com.digitalroute.devkit.ui.DJPasswordField;
import com.digitalroute.devkit.ui.DJTextField;
import com.digitalroute.devkit.ui.DRStyleUtils;
import com.digitalroute.devkit.wf.DRAgentUI;
import com.digitalroute.ui.common.renderers.TypeNameRenderer;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import clojure.lang.IFn;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LojicRealtimeStng extends DRAgentUI implements ActionListener 
{

    private static final long serialVersionUID = 1L;
	private IFn dispatchFunction;

    public LojicRealtimeStng() 
	{
	}

	public void initialize() throws DRException 
	{
		InputStream is = null;
        try 
		{
            is = LojicRealtimeExec.class.getResourceAsStream("gui.clj");
            dispatchFunction = (IFn)clojure.lang.Compiler.load(new InputStreamReader(is));
        }
 		catch(Exception e)
		{
			throw new DRException("cold not compile gui.clj", e);
		}
		finally 
		{
            if (is != null) 
			{
				try
				{
					is.close();
				}
				catch(IOException e)
				{
					throw new DRException("could not close gui.clj inputstream", e);
				}
            }
        }

		if (dispatchFunction != null)
		{
			((IFn)dispatchFunction
				.invoke("initialize"))
				.invoke(this);
		}
    }

    public void displayConfig(DRStorable settings) 
	{
		if (dispatchFunction != null)
		{
			((IFn)dispatchFunction
				.invoke("display-config"))
				.invoke(this, settings);
		}
    }

    public DRStorable collectConfig() 
	{
		if (dispatchFunction != null)
		{
			return (DRStorable) ((IFn)dispatchFunction
				.invoke("collect-config"))
				.invoke(this);
		}
		
		return new LojicData();
    }

    public String validateInput(DRStorable oldConfig) 
	{
		if (dispatchFunction != null)
		{
			return (String) ((IFn)dispatchFunction
				.invoke("validate-input"))
				.invoke(this, oldConfig);
		}
		
		return null;
    }

	public void actionPerformed(ActionEvent e) 
	{
		if (dispatchFunction != null)
		{
			((IFn)dispatchFunction
				.invoke("action-performed"))
				.invoke(this, e);
		}
    }
}