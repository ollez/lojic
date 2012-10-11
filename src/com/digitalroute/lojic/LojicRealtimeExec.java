package com.digitalroute.lojic;

import com.digitalroute.devkit.drudr.DRUDR;
import com.digitalroute.devkit.exception.DRException;
import com.digitalroute.devkit.storable.DRStorable;
import com.digitalroute.devkit.wf.DRRealtimeProcessor;
import clojure.lang.IFn;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class LojicRealtimeExec
    extends DRRealtimeProcessor
{
	public void initialize(DRStorable config) throws DRException
    {
		InputStream is = null;
        try 
		{
            is = LojicRealtimeExec.class.getResourceAsStream("core.clj");
            IFn ifn = (IFn)clojure.lang.Compiler.load(new InputStreamReader(is));
            ifn.invoke();
        }
 		catch(Exception e)
		{
			throw new DRException(e);
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
					throw new DRException(e);
				}
            }
        }
    }

    public void consume(DRUDR udr) throws DRException
    {
    }

    public void consume(byte[] bytes) throws DRException
    {
    }

    public void deinitialize() throws DRException
    {
    }
}
