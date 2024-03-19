package postgres.query.entityQuery;

import postgres.query.PostgresDelete;
import postgres.query.PostgresInsert;
import postgres.query.PostgresSelect;
import postgres.query.PostgresUpdate;

public abstract class Query {

    PostgresInsert insert() {
        return new PostgresInsert();
    }

    PostgresSelect select() {
        return new PostgresSelect();
    }

    PostgresDelete delete() {
        return new PostgresDelete();
    }
    PostgresUpdate update() {
        return new PostgresUpdate();
    }
}
