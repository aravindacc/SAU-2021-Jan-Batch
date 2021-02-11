function is_prime(num) {
    for (let i = 2; i <= Math.sqrt(num); i++)
    {
      if (num % i === 0){
          return false;
        }
    }
    return true;
}

function primeFactors(num) {
    const primes = [];
    for (let i = 2; i <= (num); i++)
    {
      while (is_prime(i) && num % i === 0) 
      {
        if (!primes.includes(i)){
            primes.push(i);
        }
        num /= i;
      }
    }
    return primes;
  }
  console.log(primeFactors(100));
  console.log(primeFactors(10));
  console.log(primeFactors(12));
  console.log(primeFactors(99));
  console.log(primeFactors(70));