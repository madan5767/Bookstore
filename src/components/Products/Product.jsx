import axios from 'axios';
import React, { useState, useEffect } from 'react'
import Card from '../card/Card';

const Product = () => {
    const [details, setDetails] = useState([]);
    const api = `http://localhost:8080/book/getAll`
    const fetchProduct = () => {
        axios.get(api)
        .then(res => {
            const data = res.data;
            setDetails(data); 
        })
        .catch(err => {
            console.log(err);
        })
    }

    useEffect(()=>{
        fetchProduct();
    },[])
    return (
        <div className="someProducts-main-container">
            <div>
            <h1 className="someProducts-h1">Book Details</h1>
            </div>        
         <div className="some-card">
           
             {details.map((detail, index) => {
                 return <Card key={detail.id} product={detail} title={detail?.title}/>
             })}
             </div>
        </div>
    )
}

export default Product
