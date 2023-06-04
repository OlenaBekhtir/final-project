import React from 'react';
import {
  Grid,
  IconButton,
  Container,
  Typography,
  Box,
  Avatar
} from '@mui/material';
import { styled } from '@mui/material/styles';
import Link from '@mui/material/Link';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import TabsProfile from './TabsProfile';
import ToolbarProfile from './ToolbarProfile';
import ButEditUser from './ButEditUser';



export const Profile = () => {

  const StyledAvatar = styled(Avatar)(({ theme }) => ({
    position: 'relative',
    '&:before': {
      content: '""',
      position: 'absolute',
      top: 0,
      left: 0,
      right: 0,
      bottom: 0,
      backgroundColor: 'rgba(0, 0, 0, 0.3)',
      opacity: 0,
      transition: 'opacity 0.3s ease',
    },
    '&:hover:before': {
      opacity: 1,
    },
  }));

  return (

    <>

      <Grid
        sx={{
          borderRight: '1px solid grey',
          borderLeft: '1px solid grey',
        }}>
        <ToolbarProfile />

        <Container sx={{ marginTop: '70px' }}>
          <Box sx={{
            bgcolor: 'grey.300',
            width: '110%',
            marginLeft: '-5%',
            height: '200px',
          }}></Box>


          <StyledAvatar
            alt="User Avatar"
            src='../../img/avatar.png'

            sx={{
              width: '25%',
              height: '25%',
              borderRadius: '50%',
              marginLeft: '20px',
              marginTop: '-15%',
              marginBottom: '20px',
              cursor: 'pointer'
            }}
          />

          <ButEditUser />

          <Box>
            <Typography sx={{
              fontSize: '24px',
              fontWeight: '900'
            }}>User</Typography>
            <Typography>@nikname</Typography>
            <Box display={'flex'}
              marginTop={'10px'}>
              <IconButton edge='start' color='gray'>
                <CalendarMonthIcon />
              </IconButton>
              <Typography mt={1}>Joined Mounth year</Typography>
            </Box>
            <Box display={'flex'}>
              <Link href="#" underline="hover" sx={{ '&:hover': { color: 'gray' } }}>
                <Typography mr={2} sx={{
                  fontSize: '14px',
                  color: 'gray'
                }}>N Following</Typography>
              </Link>
              <Link href="#" underline="hover" sx={{ '&:hover': { color: 'gray' } }}>
                <Typography sx={{
                  fontSize: '14px',
                  color: 'gray'
                }}>N Follower</Typography>
              </Link>
            </Box>
          </Box>
        </Container>

        <TabsProfile />
      </Grid>
    </>
  )
}

export default Profile
