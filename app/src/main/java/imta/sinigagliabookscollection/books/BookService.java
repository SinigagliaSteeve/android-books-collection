package imta.sinigagliabookscollection.books;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public interface BookService {
    @GET("books")
    Call<List<Book>> listBooks();
}
