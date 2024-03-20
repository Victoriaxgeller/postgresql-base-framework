package postgres.query.entityQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import postgres.conn.ConnectionFactory;
import postgres.query.*;

public abstract class Query extends ConnectionFactory {

    private static PostgresInsert insert;
    private static PostgresSelect select;
    private static PostgresUpdate update;
    private static PostgresDelete delete;
    private static PostgresCreate create;
    protected static final Logger logger = LogManager.getLogger(Query.class);

    PostgresInsert insert() {
        return insert == null ? new PostgresInsert() : insert;
    }

    PostgresSelect select() {
        return select == null ? new PostgresSelect() : select;
    }

    PostgresDelete delete() {
        return delete == null ? new PostgresDelete() : delete;
    }

    PostgresUpdate update() {
        return update == null ? new PostgresUpdate() : update;
    }

    PostgresCreate create() {
        return create == null ? new PostgresCreate() : create;
    }
}
