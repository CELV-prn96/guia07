/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import org.primefaces.component.calendar.Calendar;

/**
 *
 * @author cesar
 */
@Named
@SessionScoped
public class SesiondeUsuarioBean implements Serializable {
    private  String codigoIdioma="es";
    private static Map<String,Object> paises;
    static {
        paises=new LinkedHashMap();
        paises.put("Español", Locale.forLanguageTag("es"));
        paises.put("English", Locale.US);
        
    }

    public String getCodigoIdioma() {
        return codigoIdioma;
    }

    public void setCodigoIdioma(String codigoIdioma) {
        this.codigoIdioma = codigoIdioma;
    }

    public  Map<String, Object> getPaises() {
        return paises;
    }

   
    public void ChangeLenguage(ValueChangeEvent IdiomaChange){
        if (IdiomaChange.getNewValue()!=null){
            try {
                String nuevoCodigo= IdiomaChange.getNewValue().toString();
                for (Map.Entry<String, Object> entrySet : paises.entrySet()) {
                    //String key = entry.getKey();
                    Locale value = (Locale) entrySet.getValue();
                    if (value.toString().compareTo(nuevoCodigo)==0){
                        FacesContext.getCurrentInstance().getViewRoot().setLocale(value);
                        return;
                        
                    }
                    
                }
            } catch (Exception e) {
            }
            
        }
        
    }
    
   
}
