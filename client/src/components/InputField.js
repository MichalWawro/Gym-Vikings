import React from 'react';

function InputField(props) {
    const { className, type, label, onChange } = props;

    const handleChange = (event) => {
        onChange(event); // Pass the event to the parent component
    };

    return (
        <div className={className}>
            <label>{label}</label>
            <input type={type} className={className} onChange={handleChange} />
        </div>
    );
}

export default InputField;
