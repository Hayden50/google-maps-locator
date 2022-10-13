import React, { useContext } from "react";
import {
  BoldLink,
  BoxContainer,
  FormContainer,
  Input,
  MutedLink,
  SubmitButton,
} from "./common";
import { Marginer } from "../marginer";
import { AccountContext } from "./accountContext";
import {useRef} from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';



export function LoginForm(props) {
  ////////
  // Handling Login click by sending a post request
  const username = useRef(null);
  const password = useRef(null);

  function handleClick() {
    console.log(username.current.value);
    console.log(password.current.value);
    axios.post('/api/login', {
      username: username.current.value,
      password: password.current.value
  }).then(res => {});
  }

  /////////
  const { switchToSignup } = useContext(AccountContext);

  return (
    <BoxContainer>
      <FormContainer>
        <Input type="username" placeholder="Username" ref={username}/>
        <Input type="password" placeholder="Password" ref={password}/>
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <Marginer direction="vertical" margin="1.6em" />
      <SubmitButton type="submit" onClick={handleClick}><Link style={{color: 'white'}} to='/landing'>Log In</Link></SubmitButton>
      <Marginer direction="vertical" margin="1em" />
      <MutedLink href="#">
        Don't have an accoun?{" "}
        <BoldLink href="#" onClick={switchToSignup}>
          Signup
        </BoldLink>
      </MutedLink>
     
    </BoxContainer>
  );
}
