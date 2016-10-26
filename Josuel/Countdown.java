        /**
         * Implement the countdown function
         * This is called when the the user clicks Ready
         */
        private void countdown(){
            // Create a text counter
            JLabel counter = new JLabel("Counter from 10 to 0");
            counter.setFont(Constants.QUESTION_FONT);
            add(counter);

            final Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int i = Integer.parseInt(Constants.COUNTMAX);
                public void run() {
                    int temp = i--;
                    counter.setText(String.valueOf(temp));

                    if (temp >= 7)
                        counter.setForeground(Color.GREEN);
                    else if (temp > 3)
                        counter.setForeground(Color.YELLOW);
                    else
                        counter.setForeground(Color.RED);

                    if (i< 0)
                        timer.cancel();
                }
            }, 0, 1000);
        }
