import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import type { Book } from "../models/book";
import type { Genre } from "../models/genre";
import star from '../assets/star.png'

function Library() {
    const [token, setToken] = useState<string | null>(null);
    const [books, setBooks] = useState<Book[]>([]);
    const [genres, setGenres] = useState<Genre[]>([]);
    const [currentGenre, setCurrentGenre] = useState<string>("All");
    const [filteredBooks, setFilteredBooks] = useState<Book[]>([]);
    const navigate = useNavigate();
    
    useEffect(() => {
        const token = localStorage.getItem('token');
        setToken(token);

        fetch(`${import.meta.env.VITE_API_URL}/books/getAll`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(res => res.json())
        .then(data => {setBooks(data); setFilteredBooks(data)});

        fetch(`${import.meta.env.VITE_API_URL}/genres/getAll`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(res => res.json())
        .then(data => setGenres(data));

    }, []);

    const filterBooks = (genre: string) => {
        if (genre === "All") {
            setFilteredBooks(books);
        } else {
            setFilteredBooks(books.filter(book => book.genre.name === genre));
        }
    };

    const setActiveGenre = (genre: string) => {
        console.log(currentGenre);
        if (genre === currentGenre) {
            return "genre-button active";
        }
        return "genre-button";
    };
    
    return (
        <div>
            <section className="library-header">
                <h1>Bienvenido</h1>
            </section>
            {books.length === 0 || genres.length === 0 ? (
                <div>
                    <h1>Loading...</h1>
                </div>
            ) : (
                <div>
                    <section className="genre-section">
                        <button className={setActiveGenre("All")} onClick={() => {
                            setCurrentGenre("All");
                            filterBooks("All");
                        }}>
                            <h2>Todos</h2>
                        </button>
                    {genres.map(genre => (
                        <button key={genre.id} className={setActiveGenre(genre.name)} onClick={() => {
                            setCurrentGenre(genre.name);
                            filterBooks(genre.name);
                        }}>
                            <h2>{genre.name}</h2>
                        </button>
                    ))}
                    </section>
                    <section className="book-section">
                    {filteredBooks.map(book => (
                        <button key={book.id} className="book-button" onClick={() => navigate(`/library/books/${book.id}`)}>
                            <img src={book.image} alt={book.name} className="book-image-preview"/>
                            <h1 className="book-name-preview">{book.name}</h1>
                            <section className="review-stars">
                            {Array.from({ length: 5 }).map((_, i) => (
                                <img key={i} src={star} alt="star" className="review-star-preview"/>
                            ))}
                            </section>
                            <p className="book-price-preview">${book.price}</p>
                        </button>
                    ))}
                    </section>
                </div>
            )}
        </div>
    )
}

export default Library;