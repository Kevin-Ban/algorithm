package designPattern.flyweight;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class EmployeeReportManager implements IReportManager {

    protected String tenantId = null;

    public EmployeeReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "this is a employee report";
    }
}
