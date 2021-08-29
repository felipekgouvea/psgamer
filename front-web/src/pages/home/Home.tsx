import './Home.css';
import { ReactComponent as Gamer } from '../../assets/images/gamer.svg';
import Button from '../../components/button/Button';

function Home() {
  return (
    <div className="home-container">
      <div className="home-content">
        <div className="home-title">
          <h1>Quais jogos a galera gosta mais?</h1>
          <h2>Clique no botão abaixo e saiba quais são os jogos que os gamers estão escolhendo!</h2>
          <div>
            <Button text="QUERO SABER QUAIS SÃO" />
          </div>
        </div>
      </div>
      <Gamer className="home-image" />
    </div>
  );
}

export default Home;
