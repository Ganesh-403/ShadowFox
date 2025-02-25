import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav>
      <h2>E-Commerce</h2>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/products">Products</Link></li>
        <li><Link to="/checkout">Checkout</Link></li>
      </ul>
    </nav>
  );
};

export default Navbar;
