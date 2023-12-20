import React from 'react';
import { useEffect } from 'react';
import './AboutPage.css';
import silkaFest from '../../assets/silkafest.jpg';

const AboutPage = () => {
  useEffect(() => {
    document.title = 'Gym Viking: About';
  }, [])

  return (
    <div className="AboutPage">
      <h1>
        Welcome to the training and fitness app, where our team shares an unwavering passion for fitness and nutrition. Within our diverse pool of experts, encompassing seasoned trainers and nutritionists, we take pride in curating meticulously tailored plans aimed at empowering you to achieve your wellness aspirations. Our commitment extends beyond merely facilitating health; we are devoted to ensuring that well-being is both accessible and gratifying through our intuitively designed platform. Join us on this transformative expedition toward a happier, healthier you - together, we'll embrace the journey!
      </h1>
      <img src={silkaFest} alt="About" />
    </div>
  );
};

export default AboutPage;