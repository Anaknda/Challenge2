package Challenge2.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS books (id SERIAL PRIMARY KEY, title VARCHAR(255) NOT NULL)");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS authors (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, birth_year INTEGER, death_year INTEGER, book_id INTEGER REFERENCES books(id))");
    }
}
