package designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

    /**
     * 对象合集，当需要获取响应的对象时，首先到合集里面寻找，如果找到则返回，如果没找到则创建并返回
     */
    Map<String, IReportManager> financialReportManager = new HashMap<>(16);

    Map<String, IReportManager> employeeReportManager = new HashMap<>(16);

    IReportManager getFinancialReportManager(String tenantId){
        IReportManager r = financialReportManager.get(tenantId);
        if(r == null){
            r = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, r);
        }
        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId){
        IReportManager r = employeeReportManager.get(tenantId);
        if(r == null){
            r = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, r);
        }
        return r;
    }
}
