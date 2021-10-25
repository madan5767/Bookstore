import React from 'react'
import Card from "../card/Card"
import './Recommend.css'
import { useState} from "react";

const Recommend = () => {
    const [details, setDetails] = useState([1,2,3]);
    return (
        <div className="someProducts-main-container">
            <div>
            <h1 className="someProducts-h1">Recommended Books</h1>
            </div>
        
         <div className="some-card">           
             {details.map((detail, index) => {
                 return <Card />
             })}
             </div>
        </div>
    )
}

export default Recommend