import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> bookList;
    private List<Member> memberList;

    public Library() {
        bookList = new ArrayList<>();
        memberList = new ArrayList<>();
    }

    public void bookAdd(Book book) {
        for (Book listedBook : bookList) {
            if (listedBook.getIsbn().equals(book.getIsbn())) {
                System.out.println("이미 있는 도서입니다.");
                return;
            }
        }
        bookList.add(book);
        System.out.println("도서 " + book.getTitle() + "가 입고되었습니다.");
    }

    public void memberAdd(Member member) {
        for (Member listedMember : memberList) {
            if (listedMember.getMemberID() == member.getMemberID()) {
                System.out.println("이미 있는 회원입니다.");
                return;
            }
        }
        memberList.add(member);
        System.out.println("회원 " + member.getName() + "님의 가입이 승인되었습니다.");
    }

    public Book findBook(String bookisbn) throws NotfoundBookException {
        for (Book book : bookList) {
            if (bookisbn.equals(book.getIsbn())) {
                System.out.println(book.getTitle() + " 도서를 찾았습니다.");
                return book;
            }
        }
        throw new NotfoundBookException();
    }

    public Member findMember(int memberid) throws NotfoundMemberException {
        for (Member member : memberList) {
            if (memberid == member.getMemberID()) {
                System.out.println(member.getName()+" 회원을 찾았습니다.");
                return member;
            }
        }
        throw new NotfoundMemberException();
    }

    public void borrowBook(int memberid, String bookisbn) {
        try {
            Member member = findMember(memberid);
            Book book = findBook(bookisbn);
            if (book.isBorrowed()) {
                System.out.println(book.getTitle() + "은 대출 중입니다.");
            }
            member.borrowBook(book);
            book.setBorrowed(true);
            System.out.println(member.getName()+"님이 "+book.getTitle()+"을 대출했습니다.");
        } catch (NotfoundMemberException | NotfoundBookException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int memberid, String isbn) {
        try {
            Member member = findMember(memberid);
            Book book = findBook(isbn);

            if (member.checkBorrowing()) {
                System.out.println(member.checkBorrowing());
                book.setBorrowed(false);
                member.returnBook(book);
                System.out.println(member.getName()+"님이 "+book.getTitle()+"을 반납했습니다.");
            }
            System.out.println(member.getName()+"님이 빌린 도서가 아닙니다.");

        } catch (NotfoundMemberException | NotfoundBookException e){
            System.out.println(e.getMessage());
        }
    }
}

class Member {
    private int memberID;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public boolean checkBorrowing() {
        return !borrowedBooks.isEmpty();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isborrowed;

    public Book(String title,
                String author,
                String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isborrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isborrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isborrowed = isBorrowed;
    }
}

class NotfoundBookException extends Exception {
    public NotfoundBookException() {
        super("도서를 찾지 못했습니다.");
    }
}

class NotfoundMemberException extends Exception {
    public NotfoundMemberException() {
        super("사용자를 찾지 못했습니다.");
    }
}


public class LibraryPractice {
    public static void main(String[] args) {

        Library korealibrary = new Library();

        korealibrary.bookAdd(new Book("나는 왜 너를 사랑하는가", "알롱 드 보통", "55krb"));
        korealibrary.bookAdd(new Book("황해", "김경래", "12bsn"));
        korealibrary.bookAdd(new Book("나는 왜 너를 사랑하는가", "알롱 드 보통", "55krb"));

        korealibrary.memberAdd(new Member(1, "Jeong"));
        korealibrary.memberAdd(new Member(2, "Byeol"));
        korealibrary.memberAdd(new Member(1, "Byeol"));

        korealibrary.borrowBook(1, "55krb");
        korealibrary.returnBook(1,"55krb");
        korealibrary.returnBook(2,"55krb");
        }
    }

