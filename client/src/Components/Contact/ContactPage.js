import React from 'react';
import './ContactPage.css';

const ContactPage = () => {
  const phoneNumber = '+48 123-456-789';
  const emailAddress = 'MajkelTlakson@dzik.com';

  return (
    <div className="ContactPage">
      <h1>Contact Us</h1>
      <div className="ContactInfo">
        <h2>Phone:</h2>
        <p>{phoneNumber}</p>
      </div>
      <div className="ContactInfo">
        <h2>Email:</h2>
        <p>{emailAddress}</p>
      </div>
    </div>
  );
};

export default ContactPage;
