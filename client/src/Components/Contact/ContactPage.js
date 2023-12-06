import React from 'react';

const ContactPage = () => {
  const phoneNumber = '123-456-789';
  const emailAddress = 'MajkelTlakson@dzik.com';

  return (
    <div>
      <h1>Contact Us</h1>
      <div>
        <h2>Phone:</h2>
        <p>{phoneNumber}</p>
      </div>
      <div>
        <h2>Email:</h2>
        <p>{emailAddress}</p>
      </div>
    </div>
  );
};

export default ContactPage;