package designPattern.flyweight;

import lombok.Data;
import lombok.ToString;

/**
 * 财务报表
 */
@ToString
@Data
public class FinancialReportManager implements IReportManager {

    protected String tenantId = null;

    public FinancialReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "this is a finanacial report";
    }
}
