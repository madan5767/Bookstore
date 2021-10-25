import React from 'react'
import "./Home.css"
import Navbar from "../navbar/Navbar"
import Carousel from './Carousel'
import Footer from '../footer/Footer'
import Category from './Category'
import Recommend from './Recommend'
import Product from '../Products/Product'


const home = () => {
    return (
        <div className="home-main-Container">
            <Navbar />
            <Carousel />
            <Category />
            <Recommend/>
            <Product/>
            <Footer />     
        </div>
    )
}

export default home