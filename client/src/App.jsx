import { Grid } from '@mui/material';
import Box from '@mui/material/Box';
import Sidebar from './components/Sidebar/Sidebar'
import Footerlogin from "./components/Footerlogin/Footerlogin.jsx";

function App() {

  return (
    <Grid container spacing={2} sx={{margin: "48px"}}>
      <Sidebar />
      <Box sx={{ fontSize: '28px', fontWeight: 600, fontFamily: 'Roboto' }}>Twitter-clone</Box>
        <Footerlogin/>
    </Grid>

  )
}

export default App
