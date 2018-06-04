package com.japs.lab5db.repository;

import com.japs.lab5db.model.LibraryItself;
import com.japs.lab5db.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("Select book From Book book " +
            "inner join LibraryItself libr on book.idBook=libr.idLibraryItself" +
            " where book.storageplace.shelfNumber Like:shelfNumber and libr.visitingDate between  :date1 and :date2 ")
    List<Book> selectShelfNumberAndVisitingDateFromBook(@Param("shelfNumber") int shelfNumber, @Param("date1") LocalDate date1, @Param("date2") LocalDate date2);

    @Query("Select book From Book book " +
            " where book.deliveryndeleting.deliveryDate between  :date1 and :date2")
    List<Book> selectDelivery(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);
    @Query("Select book From Book book " +
            " where book.deliveryndeleting.deletingDate between  :date1 and :date2")
    List<Book> selectDelete(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);
    @Query("Select book From Book book " +
            " where book.containmentOfABook like:containmentOfABook")
    List<Book> selectNumber(@Param("containmentOfABook") String containmentOfABook);
    @Query("Select book From Book book " +
            " where book.bookYear like:bookYear")
    List<Book> selectNumberYear(@Param("bookYear") int bookYear);
    @Query("Select book From Book book " +
            " where book.bookAuthor like:bookAuthor")
    List<Book> selectAuthor(@Param("bookAuthor") String bookAuthor);


    @Query ("Select count(book.idBook) From Book book  group by book.containmentOfABook order by book.idBook")
    List<Long> selectAmount ();

    @Query ("Select book From Book book  group by book.containmentOfABook order by book.idBook")
    List<Book> selectBooks ();


    @Query ("Select book From Book book   ")
    List<Book> selectBookSelectAll ();
    @Query("Select book From Book book " +
            " where book.bookGenre like:bookGenre")
    List<Book> selectGenreSelector(@Param("bookGenre") String bookGenre);



}
