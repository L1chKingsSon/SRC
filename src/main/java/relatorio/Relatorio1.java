//package relatorio;
//
//import ar.com.fdvs.dj.core.DynamicJasperHelper;
//import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
//import ar.com.fdvs.dj.domain.DynamicReport;
//import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
//import model.Modelo;
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.view.JasperViewer;
//
//import java.sql.SQLException;
//import java.util.Date;
//
//public class Relatorio1<jp> {
//    FastReportBuilder drb = new FastReportBuilder();
//    DynamicReport dr = drb
//            .addColumn("id", "idCourse", Long.class.getName(), 30)
//            .addColumn("Semester", "semester", Boolean.class.getName(), 30)
//            .addColumn("Year", "year", Integer.class.getName(), 30)
//            .setTitle("Modelos")
//            .setSubtitle("This report was generated at " + new Date())
//            .setPrintBackgroundOnOddRows(true)
//            .setUseFullPageWidth(true)
//            .build();
//
//    JRDataSource ds = new JRBeanCollectionDataSource(Modelo.obterModelos());
//    JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
//
//    public Relatorio1() throws ClassNotFoundException, JRException, SQLException {
//    }
//        JasperViewer.viewReport(jp);    //finally display the report report
//}
