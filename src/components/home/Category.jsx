import React, { Component } from "react";
import Slider from "react-slick";
import './Category.css';


const Category = () => {
    var settings = {
        dots: true,
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 1000,
        pauseOnHover: true
      };
    return (
        <div className="category-mainContainer">
          <div>
            <h1 className="category-heading">
                <em>Categories</em>
            </h1>
          </div>
            
        <Slider {...settings}>
          <div className="category-subContainer">

          <h1>Fiction</h1>
          </div>
          <div className="category-subContainer">
              <h1>Drama</h1>
          </div>
          <div className="category-subContainer">
              <h1>Poetry</h1>          
          </div>
          <div className="category-subContainer">
              <h1>FolkTale</h1>          
          </div>
          <div className="category-subContainer">
              <h1>Fairy Tale</h1>          
          </div>
        </Slider>
        </div>
    )
}

export default Category