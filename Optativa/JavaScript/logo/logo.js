 class Logo {
      constructor(rows = 10, colsHalf = 5) {
        this.rows = rows;
        this.colsHalf = colsHalf;
        this.colsFull = colsHalf * 2;

        this.half = this.createHalfGrid();
        this.full = this.mirrorFullGrid();
      }

      createHalfGrid() {
        const half = Array.from({ length: this.rows }, () => Array(this.colsHalf).fill(0));

        for (let r = 0; r < this.rows; r++) {
          for (let c = 0; c < this.colsHalf; c++) {
            let prob = 0.5;

            // neighbors (left, up-left, up, up-right)
            if (c - 1 >= 0) prob += half[r][c - 1] === 1 ? 0.1 : -0.1;
            if (r - 1 >= 0 && c - 1 >= 0) prob += half[r - 1][c - 1] === 1 ? 0.1 : -0.1;
            if (r - 1 >= 0) prob += half[r - 1][c] === 1 ? 0.1 : -0.1;
            if (r - 1 >= 0 && c + 1 < this.colsHalf) prob += half[r - 1][c + 1] === 1 ? 0.1 : -0.1;

            prob = Math.max(0, Math.min(1, prob));
            half[r][c] = Math.random() < prob ? 1 : 0;
          }
        }
        return half;
      }

      mirrorFullGrid() {
        const full = Array.from({ length: this.rows }, () => Array(this.colsFull).fill(0));
        for (let r = 0; r < this.rows; r++) {
          for (let c = 0; c < this.colsHalf; c++) {
            full[r][c] = this.half[r][c]; // left
            full[r][this.colsHalf + c] = this.half[r][this.colsHalf - 1 - c]; // mirrored
          }
        }
        return full;
      }
    }

    const gridEl = document.getElementById('grid');
    const color1Input = document.getElementById('color1');
    const color0Input = document.getElementById('color0');
    const regenerateBtn = document.getElementById('regenerate');
    const downloadBtn = document.getElementById('download');

    let logo = new Logo(); // initial logo

    function buildGrid(grid) {
      gridEl.innerHTML = '';
      for (let r = 0; r < 10; r++) {
        for (let c = 0; c < 10; c++) {
          const val = grid[r][c];
          const div = document.createElement('div');
          div.className = 'cell';
          div.style.backgroundColor = val === 1 ? color1Input.value : color0Input.value;
          gridEl.appendChild(div);
        }
      }
    }

    function repaint() {
      buildGrid(logo.full);
    }

    // initial render
    repaint();

    // live color change
    color1Input.addEventListener('input', repaint);
    color0Input.addEventListener('input', repaint);

    // regenerate grid
    regenerateBtn.addEventListener('click', () => {
      logo = new Logo();
      repaint();
    });

    // download as PNG
    downloadBtn.addEventListener('click', () => {
        const cellSize = 20; // size of each cell in pixels 
        const canvas = document.createElement('canvas');
        canvas.width = logo.colsFull * cellSize;
        canvas.height = logo.rows * cellSize;
        const ctx = canvas.getContext('2d');

        for (let r = 0; r < logo.rows; r++) {
            for (let c = 0; c < logo.colsFull; c++) {
                ctx.fillStyle = logo.full[r][c] === 1 ? color1Input.value : color0Input.value;
                ctx.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
            }
        }

        const link = document.createElement('a');
        link.download = 'logo.png';
        link.href = canvas.toDataURL('image/png');
        link.click();
    });  