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


export function SignupForm(props) {
  ////////
  // Handling Signup click by sending a post request
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
  const { switchToLogin } = useContext(AccountContext);

  return (
    <BoxContainer>
      <FormContainer>
        <Input type="username" placeholder="Username" ref={username}/>
        <Input type="password" placeholder="Password" ref={password}/>
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <Marginer direction="vertical" margin="1.6em" />
      <SubmitButton type="submit" onClick={handleClick}>Signup</SubmitButton>
      <Marginer direction="vertical" margin="1em" />
      <MutedLink href="#">
        Already have an account?
        <BoldLink href="#" onClick={switchToLogin}>
          Login
        </BoldLink>
      </MutedLink>
    </BoxContainer>
  );
}
