import { useParams } from "react-router";
import { useState, useEffect } from "react";
import type { Book } from "../models/book";
import star from "../assets/star.png";

function BookDetails() {
    const { id } = useParams();
    const [book, setBook] = useState<Book>({} as Book);
    
    useEffect(() => {
        fetch(`${import.meta.env.VITE_API_URL}/books/byId?id=${id}`, {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then(res => res.json())
        .then(data => setBook(data));
    }, [id]);
    
    return (
        <div>
            <section className="library-header">
                <h1>Bienvenido</h1>
            </section>
            {book && (
                <div className="book-details-container">
                    <section className="book-details-section">
                        <img src={book.image} alt={book.name} className="book-image"/>
                        <section className="book-details-cart">
                            <h1 className="book-name">{book.name}</h1>
                            <p className="book-price">${book.price}</p>
                            <div className="book-quantity">
                                <button className="quantity-button">+</button>
                                <h1>1</h1>
                                <button className="quantity-button">-</button>
                            </div>
                            <h2 className="book-genre">Categoria: {book.genre?.name}</h2>
                        </section>
                    </section>
                    
                    <p className="book-summary">{book.summary}</p>
                </div>
            )}

            <h2>Reviews (0)</h2>
            <section className="review-line"></section>
            <h2>Review</h2>
            <h3>There are no reviews yet</h3>
            <h3>Be the first to review this book</h3>
            <h3>Your email address will not be published. Required fields are marked *</h3>
            <h3>Your rating: *</h3>
            {Array.from({ length: 5 }).map((_, i) => (
                                <img key={i} src={star} alt="star" className="review-star-preview"/>
                            ))}
            <h3>Your review: *</h3>
            <textarea></textarea>
        </div>
    );
}

export default BookDetails;