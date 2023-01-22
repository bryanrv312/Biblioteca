
package conexion;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


public class hora {

    public String horafecha() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
        Date fecha = new Date();
        String dia = formatofecha.format(fecha);
        return dia;
    }

}
