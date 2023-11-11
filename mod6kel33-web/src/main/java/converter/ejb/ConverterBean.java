/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package converter.ejb;
import java.text.DecimalFormat;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author Erina
 */
@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanLocal {
    
    private final DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public String rtok(double r) {
        String result = twoDigits.format((((r / 0.8) + 273.15) * 100)/100.0);
        return result;
    }
    
    public String ktor(double k) {
        String result = twoDigits.format(((k - 273.15) * 4.0/5.0 *100)/100.0);
        return result;
    }    
}