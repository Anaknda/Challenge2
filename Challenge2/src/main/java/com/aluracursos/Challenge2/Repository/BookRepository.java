package Challenge2.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long>  {
    List<Author> getAuthors();
}
