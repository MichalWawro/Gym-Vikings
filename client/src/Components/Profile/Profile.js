import React, { useEffect, useState } from "react";
import './Profile.css';
import DefaultAvatar from '../../assets/vikinglogo2.png'

const Profile = ({ user }) => {
    useEffect(() => {
        document.title = 'Gym Viking: Diets';
      }, [])

   let date = user.creationDate.slice(0,19)

   if (!user.bmi){
    user.bmi = 0
   }
   else{
    user.bmi = Math.round(user.bmi * 100) / 100
   }

   let level = user.level
   let gender = user.gender
   if(level==null)
   {
    level = 1;
   }
   if(gender==null)
   {
    gender = NaN;
   }
    return (
        <>
            <div style={{padding: "150px"}}>
                <div className="Card">
            <img className="Avatar" src={DefaultAvatar} width={250} height={250} alt="AvatarLogo" />
            <div className="GymMembershipText">MEMBERSHIP CARD</div>
            <div className="LevelText" style={{ top: "20px", left: "800px"}} ><div style={{position: "absolute", top: "18%", left: "40%", margin: "0"}}>{level}</div></div>
            <div className="InfoText" style={{width: "400px", top: "80px", left: "50px"}}>Name:</div>
            <div className="Text" style={{width: "400px", top: "120px", left: "50px"}}>{user.username}</div>
            <div className="InfoText" style={{width: "80px", top: "80px", left: "480px"}}>Age:</div>
            <div className="Text" style={{width: "80px", top: "120px", left: "480px"}}>{user.age}</div>            
            <div className="InfoText" style={{width: "400px", top: "170px", left: "50px"}}>Email:</div>
            <div className="Text" style={{width: "510px", top: "210px", left: "50px"}}>{user.email}</div>

            <div className="InfoText" style={{width: "400px", top: "280px", left: "50px"}}>Weight:</div>
            <div className="Text" style={{width: "120px", top: "320px", left: "50px"}}>{user.weight}</div>
            <div className="InfoText" style={{width: "400px", top: "280px", left: "200px"}}>Height:</div>
            <div className="Text" style={{width: "120px", top: "320px", left: "200px"}}>{user.height}</div>  
            <div className="InfoText" style={{width: "400px", top: "280px", left: "350px"}}>BMI:</div>
            <div className="Text" style={{width: "120px", top: "320px", left: "350px"}}>{user.bmi}</div>  
            <div className="InfoText" style={{width: "400px", top: "280px", left: "500px"}}>Gender:</div>
            <div className="Text" style={{width: "120px", top: "320px", left: "500px"}}>{user.gender}</div>
            <div className="InfoText" style={{width: "400px", top: "280px", left: "650px"}}>Id:</div>
            <div className="Text" style={{width: "120px", top: "320px", left: "650px"}}>{user.id}</div>  
            <div className="InfoText" style={{width: "500px", top: "550px", left: "25px" ,  fontSize: "16px"}}>Member since: {date}</div>
            <div className="InfoText" style={{width: "200px", top: "540px", left: "740px" ,  fontSize: "16px"}}>Online TrainerⒸ</div>
           
                </div>
            </div>
        </>
    );
};



export default Profile;