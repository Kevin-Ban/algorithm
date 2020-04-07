package mybatis.test;

public class GPSqlSession {

    private GPConfiguretion gpConfiguretion;

    private GPExecutor gpExecutor;

    public GPSqlSession(GPConfiguretion gpConfiguretion, GPExecutor gpExecutor) {
        this.gpConfiguretion = gpConfiguretion;
        this.gpExecutor = gpExecutor;
    }
}
