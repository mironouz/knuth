package chapter1

func gcd(m int64, n int64) int64  {
	d := m % n
	for d != 0 {
		m = n
		n = d
		d = m % n
	}
	return n
}
