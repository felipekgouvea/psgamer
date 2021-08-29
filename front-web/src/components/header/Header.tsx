import './Header.css';
import { ReactComponent as LogoImage } from '../../assets/images/logo.svg';

function Header() {
  return (
    <div className="header-container">
      <LogoImage />
      <h1>
        <span>Big Game</span> Survey
      </h1>
    </div>
  );
}

export default Header;
