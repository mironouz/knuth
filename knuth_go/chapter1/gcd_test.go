package chapter1

import "testing"

func TestGcd(t *testing.T) {
	type args struct {
		m int64
		n int64
	}
	tests := []struct {
		name string
		args args
		want int64
	}{
		{
			name: "GCD for 7 ad 5 is 1",
			args: args{7, 5},
			want: 1,
		},
		{
			name: "GCD for 18 ad 6 is 6",
			args: args{18, 6},
			want: 6,
		},
		{
			name: "GCD for 2166 ad 6099 is 57",
			args: args{2166, 6099},
			want: 57,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := gcd(tt.args.m, tt.args.n); got != tt.want {
				t.Errorf("gcd() = %v, want %v", got, tt.want)
			}
		})
	}
}

func BenchmarkGcdBestCase(b *testing.B) {
	for i := 0; i < b.N; i++ {
		gcd(1, 1)
	}
}


func BenchmarkGcdWorstCase(b *testing.B) {
	for i := 0; i < b.N; i++ {
		gcd(7540113804746346429, 4660046610375530309)
	}
}
