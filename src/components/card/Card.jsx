import React from 'react'
import './Card.css'
import image1 from "../../assets/images/img6.jpg"

const Card = ({product,title}) => {
    console.log(title);
    console.log(product);
    return (
        <div className="Card-main-container">
            <div className="card-sub-container">
           <div className="desc">
            <img src={image1}  height="200px" width="250px"className="card-image" />
            <div class="overlay">View details</div>
            </div>         
            <h4 className="card-h4"><em>{title}</em></h4>
            <p className="card-p">Description</p>
            <p className="card-p">Rating</p>
            <p className="card-p">Price: Rs</p>
            <button class="card-button">Add to Cart</button>
            </div>
        </div>
    )
}

export default Card