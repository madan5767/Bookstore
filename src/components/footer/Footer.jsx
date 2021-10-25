import React from 'react'
import "./Footer.css"

const Footer = () => {
    return (
        <div>          
        <footer>
            <div class="footer-content">
            <h3>BookStore</h3>
            <p>Bookstore sells millions of books at the lowest everyday prices. We personally assess every book's quality and offer rare, out-of-print treasures. Read more. Spend less.</p>
            <h5>Follow us on:</h5>
            <ul class="socials">           
                <li><a href="#">Facebook<i class="bi bi-facebook"></i></a></li>
                <li><a href="#">Twitter<i class="bi bi-twitter"></i></a></li>
                <li><a href="#">Instagram<i class="bi bi-instagram"></i></a></li>
            </ul>
            </div>
            <div class="footer-bottom">
            <p>@Copyright 2021</p>
            </div>
        </footer>
        </div>
    )
}

export default Footer