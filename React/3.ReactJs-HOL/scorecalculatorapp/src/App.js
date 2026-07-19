import { CalculateScore } from './Components/CalculatorScore';

function App() {
  return (
    <div>
      <CalculateScore
        Name={"Steeve"}
        School={"DNV Public School"}
        total={284}
        goal={3}
      />
    </div>
  );
}

export default App;