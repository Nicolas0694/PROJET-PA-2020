package org.plugins;

import org.commun.Exemple;

/**
 * Hello world!
 *
 */
public class PluginExemple implements Exemple 
{

    public PluginExemple() {
        
    }

    @Override
    public void hello() {
        System.out.println("hello plugin exemple");

    }
}
