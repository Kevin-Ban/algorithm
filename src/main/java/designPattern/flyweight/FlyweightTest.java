package designPattern.flyweight;

public class FlyweightTest {

    public static void main(String[] args){
        ReportManagerFactory factory = new ReportManagerFactory();
        IReportManager employee = factory.getEmployeeReportManager("employee");
        IReportManager financial = factory.getFinancialReportManager("financial");
        System.out.println(employee);
        System.out.println(financial);
    }
}
