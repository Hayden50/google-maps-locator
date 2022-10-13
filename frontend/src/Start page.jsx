import LoginForm from '../components/LoginForm';
// import '../styles/Login.css';

import styled from "styled-components";
import { AccountBox } from "../components/accountBox";

const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const Login = () => {
    return (
    <Container>
        <AccountBox />
    </Container>
    );
}

export default Login;