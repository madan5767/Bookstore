import React from 'react'
import "./Navbar.css"
import { Link } from "react-router-dom";

const navbar = () => {
    return (
    <div>
        
  <nav class="navbar navbar-expand-lg navbar-light bg-dark">
  <div class="container-fluid">
    <h2 class="navbar-title">BookStore</h2>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <Link to="/" class="nav-link active" aria-current="page"><i class="bi bi-house-door-fill"></i>Home</Link>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Category
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><Link to="/fiction" class="dropdown-item">Fiction</Link></li>
            <li><Link to="/drama" class="dropdown-item">Drama</Link></li>
            <li><Link to="/poetry" class="dropdown-item">Poetry</Link></li>
            <li><Link to="/folktale" class="dropdown-item">Folktale</Link></li>
            <li><Link to="/fairytale" class="dropdown-item">Fairy Tale</Link></li>
          </ul>
         </li>
         <li class="nav-item">
         <Link to="/register" class="nav-link"><i class="bi bi-person-plus-fill"></i>Signup</Link>
        </li>
        <li class="nav-item">
        <Link to="/login" class="nav-link"><i class="bi bi-box-arrow-in-right"></i>Login</Link>
        </li>
        <li class="nav-item">
          <Link to="/myCart" class="nav-link"><i class="bi bi-cart2"></i>My Cart</Link>
        </li>    
      </ul>  
    </div>
  </div>
</nav>
</div>
    )
}

export default navbar